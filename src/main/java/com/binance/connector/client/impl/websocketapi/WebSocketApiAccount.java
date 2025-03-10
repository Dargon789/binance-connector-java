package com.binance.connector.client.impl.websocketapi;

import org.json.JSONObject;

import com.binance.connector.client.utils.JSONParser;
import com.binance.connector.client.utils.ParameterChecker;
import com.binance.connector.client.utils.websocketapi.WebSocketApiRequestHandler;

/**
 * <h2>Account Requests</h2>
 * All requests under the
 * <a href="https://developers.binance.com/docs/binance-spot-api-docs/web-socket-api/account-requests">Account requests</a>
 * section of the WebSocket API documentation will be implemented in this class.
 * <br>
 * Response will be returned as callback.
 */
public class WebSocketApiAccount implements WebSocketApiModule {
    
    private WebSocketApiRequestHandler handler;

    public WebSocketApiAccount(WebSocketApiRequestHandler handler) {
        this.handler = handler;
    }

    /**
     * Query account information.
     * 
     * @param parameters JSONObject composed by key-value pairs:
     * <br><br>
     * recvWindow -- optional/int -- The value cannot be greater than 60000 <br>
     * requestId -- optional/String or int <br>
     * 
     * @see <a href="https://developers.binance.com/docs/binance-spot-api-docs/web-socket-api/account-requests#account-information-user_data">
     *     https://developers.binance.com/docs/binance-spot-api-docs/web-socket-api/account-requests#account-information-user_data</a>
     */
    public void accountStatus(JSONObject parameters) {
        this.handler.signedRequest("account.status", parameters);
    }

    /**
     * Query your current order rate limit.
     * 
     * @param parameters JSONObject composed by key-value pairs:
     * <br><br>
     * recvWindow -- optional/int -- The value cannot be greater than 60000 <br>
     * requestId -- optional/String or int <br>
     * 
     * @see <a href="https://developers.binance.com/docs/binance-spot-api-docs/web-socket-api/account-requests#unfilled-order-count-user_data">
     *     https://developers.binance.com/docs/binance-spot-api-docs/web-socket-api/account-requests#unfilled-order-count-user_data</a>
     */
    public void accountRateLimitsOrders(JSONObject parameters) {
        this.handler.signedRequest("account.rateLimits.orders", parameters);
    }

    /**
     * Query information about all your orders – active, canceled, filled – filtered by time range.<br>
     * 
     * If startTime and/or endTime are specified, orderId is ignored.<br>
     * 
     * @param symbol String
     * @param parameters JSONObject composed by key-value pairs:
     * <br><br>
     * orderId -- optional/int -- Order ID to begin at<br>
     * startTime -- optional/int -- Timestamp in ms <br>
     * endTime -- optional/int -- Timestamp in ms <br>
     * limit -- optional/int -- Default 500; max 1000. <br>
     * recvWindow -- optional/int -- The value cannot be greater than 60000 <br>
     * requestId -- optional/String or int <br>
     * 
     * @see <a href="https://developers.binance.com/docs/binance-spot-api-docs/web-socket-api/account-requests#account-order-history-user_data">
     *     https://developers.binance.com/docs/binance-spot-api-docs/web-socket-api/account-requests#account-order-history-user_data</a>
     */
    public void accountAllOrders(String symbol, JSONObject parameters) {
        ParameterChecker.checkParameterType(symbol, String.class, "symbol");
        parameters = JSONParser.addKeyValue(parameters, "symbol", symbol);

        this.handler.signedRequest("allOrders", parameters);
    }

    /**
     * Query information about all your OCOs, filtered by time range.<br>
     * 
     * If startTime and/or endTime are specified, fromId is ignored.<br>
     * 
     * @param parameters JSONObject composed by key-value pairs:
     * <br><br>
     * fromId -- optional/int -- Order list ID to begin at<br>
     * startTime -- optional/int -- Timestamp in ms <br>
     * endTime -- optional/int -- Timestamp in ms <br>
     * limit -- optional/int -- Default 500; max 1000. <br>
     * recvWindow -- optional/int -- The value cannot be greater than 60000 <br>
     * requestId -- optional/String or int <br>
     * 
     * @see <a href="https://developers.binance.com/docs/binance-spot-api-docs/web-socket-api/account-requests#account-order-list-history-user_data">
     *     https://developers.binance.com/docs/binance-spot-api-docs/web-socket-api/account-requests#account-order-list-history-user_data</a>
     */
    public void accountAllOcoOrders(JSONObject parameters) {
        this.handler.signedRequest("allOrderLists", parameters);
    }

    /**
     * Query information about all your trades, filtered by time range.<br>
     * 
     * @param symbol String
     * @param parameters JSONObject composed by key-value pairs:
     * <br><br>
     * orderId -- optional/int -- Order list ID to begin at<br>
     * startTime -- optional/int -- Timestamp in ms <br>
     * endTime -- optional/int -- Timestamp in ms <br>
     * fromId -- optional/int -- Trade ID to begin at<br>
     * limit -- optional/int -- Default 500; max 1000. <br>
     * recvWindow -- optional/int -- The value cannot be greater than 60000 <br>
     * requestId -- optional/String or int <br>
     * 
     * @see <a href="https://developers.binance.com/docs/binance-spot-api-docs/web-socket-api/account-requests#account-trade-history-user_data">
     *     https://developers.binance.com/docs/binance-spot-api-docs/web-socket-api/account-requests#account-trade-history-user_data</a>
     */
    public void accountTradeHistory(String symbol, JSONObject parameters) {
        ParameterChecker.checkParameterType(symbol, String.class, "symbol");
        parameters = JSONParser.addKeyValue(parameters, "symbol", symbol);

        this.handler.signedRequest("myTrades", parameters);
    }

    /**
     * Displays the list of orders that were expired because of STP trigger.<br>
     * 
     * @param symbol String
     * @param parameters JSONObject composed by key-value pairs:
     * <br><br>
     * preventedMatchId -- optional/long <br>
     * orderId -- optional/long <br>
     * fromPreventedMatchId -- optional/long <br>
     * limit -- optional/int -- Default 500; max 1000. <br>
     * recvWindow -- optional/int -- The value cannot be greater than 60000 <br>
     * requestId -- optional/String or int <br>
     * 
     * @see <a href="https://developers.binance.com/docs/binance-spot-api-docs/web-socket-api/account-requests#account-prevented-matches-user_data">
     *     https://developers.binance.com/docs/binance-spot-api-docs/web-socket-api/account-requests#account-prevented-matches-user_data</a>
     */
    public void accountPreventedMatches(String symbol, JSONObject parameters) {
        ParameterChecker.checkParameterType(symbol, String.class, "symbol");
        ParameterChecker.checkOneOfParametersRequired(parameters, "preventedMatchId", "orderId");
        ParameterChecker.checkOnlyOneOfParameters(parameters, "preventedMatchId", "orderId");
        parameters = JSONParser.addKeyValue(parameters, "symbol", symbol);

        this.handler.signedRequest("myPreventedMatches", parameters);
    }

    /**
     * Retrieves allocations resulting from SOR order placement.<br>
     * 
     * @param symbol String
     * @param parameters JSONObject composed by key-value pairs:
     * <br><br>
     * startTime -- optional/long -- Timestamp in ms <br>
     * endTime -- optional/long -- Timestamp in ms <br>
     * fromAllocationId -- optional/int <br>
     * limit -- optional/int -- Default 500; max 1000. <br>
     * orderId -- optional/long <br>
     * recvWindow -- optional/int -- The value cannot be greater than 60000 <br>
     * requestId -- optional/String or int <br>
     * 
     * @see <a href="https://developers.binance.com/docs/binance-spot-api-docs/web-socket-api/account-requests#account-allocations-user_data">
     *     https://developers.binance.com/docs/binance-spot-api-docs/web-socket-api/account-requests#account-allocations-user_data</a>
     */
    public void accountAllocations(String symbol, JSONObject parameters) {
        ParameterChecker.checkParameterType(symbol, String.class, "symbol");
        parameters = JSONParser.addKeyValue(parameters, "symbol", symbol);

        this.handler.signedRequest("myAllocations", parameters);
    }

    /**
     * Get current account commission rates. <br>
     * 
     * @param symbol String
     * @param parameters JSONObject composed by key-value pairs:
     * <br><br>
     * requestId -- optional/String or int <br>
     * 
     * @see <a href="https://developers.binance.com/docs/binance-spot-api-docs/web-socket-api/account-requests#account-commission-rates-user_data">
     *     https://developers.binance.com/docs/binance-spot-api-docs/web-socket-api/account-requests#account-commission-rates-user_data</a>
     */
    public void accountCommissionRates(String symbol, JSONObject parameters) {
        ParameterChecker.checkParameterType(symbol, String.class, "symbol");
        parameters = JSONParser.addKeyValue(parameters, "symbol", symbol);

        this.handler.signedRequest("account.commission", parameters);
    }
}
