package plasma.airbnb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import plasma.airbnb.model.Application;
import plasma.airbnb.reposiroty.ApplicationRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private ApplicationRepository applicationRepository;

    public String accept(Long applicationId) {
        Application application = applicationRepository.findById(applicationId).orElseThrow();
//        application.
        return "Successfully accepted!";
    }
}
