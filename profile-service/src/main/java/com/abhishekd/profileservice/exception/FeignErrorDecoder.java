package com.abhishekd.profileservice.exception;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FeignErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {

        log.info("Method Key " + methodKey);
        log.info("Response " + response.body());
        //Response {"errorCode":409,"errorStatus":"CONFLICT","errorMessage":"Resource with resourceName={webdev2} already exists","path":"/users","timestamp":"2019-12-02 11:24:46"}
        if (response.status() >= 400 && response.status() <= 499) {
            throw new BadRequestException("Bad Request");
        }

        return defaultErrorDecoder.decode(methodKey, response);
    }
}
