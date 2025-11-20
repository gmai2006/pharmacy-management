package com.datascience9.pharmacy.api.manual;

import com.datascience9.pharmacy.dao.manual.AuthLogDao;
import com.datascience9.pharmacy.entity.AuthLogs;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Path("/getlogs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthLogResource {

    @Inject private AuthLogDao authLogDao;

    @GET
    public Response getLogs(
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("size") @DefaultValue("20") int size,
            @QueryParam("sort") @DefaultValue("createdAt") String sort,
            @QueryParam("dir") @DefaultValue("desc") String dir,
            @QueryParam("status") String status,
            @QueryParam("q") String q,
            @QueryParam("from") String fromDate,
            @QueryParam("to") String toDate) {
        OffsetDateTime from = fromDate != null ? getOffsetDate(fromDate) : null;
        OffsetDateTime to = toDate != null ? getOffsetDate(toDate) : null;

        List<AuthLogs> logs = authLogDao.findLogs(page, size, sort, dir, status, q, from, to);
        long total = authLogDao.countLogs(status, q, from, to);

        PageResponse<AuthLogs> response = new PageResponse<>();
        response.content = logs;
        response.totalElements = total;
        response.page = page;
        response.size = size;
        response.totalPages = (int) Math.ceil((double) total / size);
        response.hasNext = page < response.totalPages - 1;
        response.hasPrevious = page > 0;

        return Response.ok(response).build();
    }

    static OffsetDateTime getOffsetDate(String date) {
        LocalDate d = LocalDate.parse(date); // fromDate = "2025-01-01"
        OffsetDateTime odt = d.atStartOfDay(ZoneOffset.UTC).toOffsetDateTime();
        return odt;
    }
}
