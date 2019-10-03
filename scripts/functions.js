endpoint.track = {};
endpoint.track.post = function (reqObj) {
    return endpoint.post('/Track', reqObj);
};

endpoint.pickUp = {};
endpoint.pickUp.post = function (reqObj) {
    return endpoint.post('/Pickup', reqObj);
};

endpoint.rate = {};
endpoint.rate.post = function (reqObj) {
    return endpoint.post('/Rate', reqObj);
};

endpoint.ship = {};
endpoint.ship.post = function (reqObj) {
    return endpoint.post('/Ship', reqObj);
};

endpoint.void = {};
endpoint.void.post = function (reqObj) {
    return endpoint.post('/Void', reqObj);
};

endpoint.lbRecovery = {};
endpoint.lbRecovery.post = function (reqObj) {
    return endpoint.post('/LBRecovery', reqObj);
};

endpoint.timeInTransit = {};
endpoint.timeInTransit.post = function (reqObj) {
    return endpoint.post('/TimeInTransit', reqObj);
};

endpoint.av = {};
endpoint.av.post = function (reqObj) {
    return endpoint.post('/AV', reqObj);
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

/////////////////////////////////////
// Public API - Generic Functions
/////////////////////////////////////

endpoint.post = function (url, options) {
    return endpoint._post({
        path: url,
        body: options
    });
};