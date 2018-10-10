package com.example.testingapplication.api

data class DotResponse(var total: String?,
                       var merchant: Merchant?,
                       var batch: String?) {


    data class Merchant(var id: String?,
                        var email: String?,
                        var address: String?,
                        var name: String?,
                        var latitude: String?,
                        var contact: String?,
                        var logtitude: String?)
}
