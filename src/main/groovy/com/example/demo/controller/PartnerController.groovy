package com.example.demo.controller

import groovy.util.logging.Slf4j
import io.micrometer.core.annotation.Timed
import io.swagger.annotations.Api
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiImplicitParams
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Slf4j
@RestController
@Api(tags = "Partner Controller")
public class PartnerController {

    @Timed
    @RequestMapping(value = "/v1/partner/products", method = RequestMethod.GET)
    @ApiOperation(value = "Get the partner products",
            notes = "Get the partner products",
            response = HttpStatus.class)
    @ApiImplicitParams(@ApiImplicitParam(name = "Authorization", value = "Authorization",
            dataType = "string", paramType = "header", required = true))
    public ResponseEntity<HttpStatus> getProgramMapping() {
        log.info("Enter API::/v1/partner/products")
        return new ResponseEntity<>(HttpStatus.OK)
    }
}