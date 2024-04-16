package ru.surin.yatm.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.surin.yatm.controller.api.SampleControllerApi;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class SampleController implements SampleControllerApi {

    @Override
    public Map<String, String> getMeAMap() {
        return Map.of("Key", "Hello world!");
    }
}
