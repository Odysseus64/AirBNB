package plasma.airbnb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import plasma.airbnb.enums.DecisionStatus;
import plasma.airbnb.model.Application;
import plasma.airbnb.reposiroty.ApplicationRepository;

/**
 * Created by mouflon on 05.07.2023.
 */
@Service
@RequiredArgsConstructor
public class ApplicationService {

    private ApplicationRepository applicationRepository;

    public String accept(Long applicationId) {
        Application application = applicationRepository.findById(applicationId).orElseThrow();
        application.setAccepted(true);
        application.setDecisionStatus(DecisionStatus.ACCEPT);
        applicationRepository.save(application);
        return "Accepted!";
    }

    public String reject(Long applicationId, String message) {
        Application application = applicationRepository.findById(applicationId).orElseThrow();
        application.setDecisionStatus(DecisionStatus.REJECT);
        application.setAccepted(false);
        if (!application.isAccepted()) {
            application.setMessage(message);
        }
        return "Rejected!";
    }
}