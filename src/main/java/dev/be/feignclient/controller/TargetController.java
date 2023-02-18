package dev.be.feignclient.controller;

import dev.be.feignclient.common.dto.BaseRequestInfo;
import dev.be.feignclient.common.dto.BaseResponseInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/target_server")
@RestController
public class TargetController {

    @GetMapping("/get")
    public BaseResponseInfo demoGet(@RequestHeader("CustomHeaderName") String header,
                                    @RequestParam("name") String name,
                                    @RequestParam("age") Long age) {
        return BaseResponseInfo.builder()
            .header(header)
            .name(name + " from target server")
            .age(age)
            .build();
    }

    @PostMapping("/post")
    public BaseResponseInfo demoPost(@RequestHeader("CustomHeaderName") String header,
                                     @RequestBody BaseRequestInfo body) {
        return BaseResponseInfo.builder()
            .header(header)
            .name(body.getName())
            .age(body.getAge())
            .build();
    }

    @GetMapping("/error")
    public ResponseEntity<BaseResponseInfo> demoErrorDecoder() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
