/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.voice.v1.connectionpolicy;

import com.twilio.base.Fetcher;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class ConnectionPolicyTargetFetcher extends Fetcher<ConnectionPolicyTarget> {
    private final String pathConnectionPolicySid;
    private final String pathSid;

    /**
     * Construct a new ConnectionPolicyTargetFetcher.
     *
     * @param pathConnectionPolicySid The SID of the Connection Policy that owns
     *                                the Target
     * @param pathSid The unique string that identifies the resource
     */
    public ConnectionPolicyTargetFetcher(final String pathConnectionPolicySid,
                                         final String pathSid) {
        this.pathConnectionPolicySid = pathConnectionPolicySid;
        this.pathSid = pathSid;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Fetched ConnectionPolicyTarget
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public ConnectionPolicyTarget fetch(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            Domains.VOICE.toString(),
            "/v1/ConnectionPolicies/" + this.pathConnectionPolicySid + "/Targets/" + this.pathSid + "",
            client.getRegion()
        );

        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("ConnectionPolicyTarget fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return ConnectionPolicyTarget.fromJson(response.getStream(), client.getObjectMapper());
    }
}