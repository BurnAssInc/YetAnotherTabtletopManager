package ru.surin.yatm.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.surin.yatm.utils.RestUtils;

import java.util.Map;

@Tag(name = "Sample controller", description = "Example of swagger docs")
@RequestMapping(value = RestUtils.API_VERSION,
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
)
public interface SampleControllerApi {

    @Operation(summary = "Simple get object endpoint")
    @GetMapping(value = "/getSomeObject", consumes = MediaType.ALL_VALUE)
    Map<String, String> getMeAMap();
}
