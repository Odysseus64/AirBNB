package plasma.controllers;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RestController;
import plasma.reposiroty.ImageSRepository;


@RestController
@RequiredArgsConstructor
public class ImageController {
    private final ImageSRepository repository;
}
