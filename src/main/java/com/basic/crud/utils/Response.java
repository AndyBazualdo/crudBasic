package com.basic.crud.utils;

/**
 * @author lazaro on 10/13/2019.
 * @project basicCrud
 */


/**
 * Implements Responses for implementing response the status of the controller and methods.
 *
 * @author Raul Laredo
 * @version v1.0
 */
public class Response {

    private String url;
    private Status status;
    private String message;
    /**
     * Get Status  for response
     * @param
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Set Status  for response
     * @param
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Get URl  for response
     * @param
     */
    public String getUrl() {
        return url;
    }

    /**
     * Set URl  for response
     * @param
     */
    public void setUrl(String url) {

        this.url = url;
    }

    /**
     * Get message  for response
     * @param
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set message  for response
     * @param
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Status for responding
     */
    public enum Status{
        Ok,
        Query_not_executed,
        Created,
        NoContent,
        BadRequest,
        Forbidden,
        NotFound,
        MethodNotAllowed,
        Conflict,
        InternalServerError
    }
}

