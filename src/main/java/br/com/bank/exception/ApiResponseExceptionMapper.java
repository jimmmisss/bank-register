package br.com.bank.exception;

import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

import javax.ws.rs.core.Response;

public class ApiResponseExceptionMapper implements ResponseExceptionMapper<RuntimeException> {

    @Override
    public RuntimeException toThrowable(Response response) {

        if (response.getStatus() == 400) {
            return new IllegalArgumentException();
        }
        return null;
    }
}