endpoint.track = {};
endpoint.track.request = function (reqObj) {
    return endpoint.post('/Track', reqObj);
};

endpoint.track.trackByInquiryNumber = function (inquiryNumber) {

    var reqObj = {
        "TrackRequest": {
            "Request": {
                "RequestOption": "1",
                "TransactionReference": {
                    "CustomerContext": new Date().toString()
                }
            },
            "InquiryNumber": inquiryNumber
        }
    };


    return endpoint.post('/Track', reqObj);
};

endpoint.request = function (url, reqObj) {
    return endpoint.post(url, reqObj);
};

/////////////////////////////////////
// Public API - Generic Functions
/////////////////////////////////////

endpoint.post = function (url, options) {
    return endpoint._post({
        path: url,
        body: options
    });
};