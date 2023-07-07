package plasma.airbnb.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import plasma.airbnb.dto.request.ProductRequest;
import plasma.airbnb.dto.response.ApplicationResponse;
import plasma.airbnb.enums.DecisionStatus;
import plasma.airbnb.model.Application;
import plasma.airbnb.model.Product;
import plasma.airbnb.reposiroty.ApplicationRepository;
import javax.transaction.Transactional;
import java.util.NoSuchElementException;

/**
 * Created by mouflon on 05.07.2023.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final ProductService productService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Transactional
    public ApplicationResponse createApplication(Long userId, ProductRequest productRequest) {
        Product product = modelMapper.map(productRequest, Product.class);
        productService.save(product);
        Application application = Application.builder()
                .accepted(false)
                .user(userService.findById(userId))
                .build();
        application.setProduct(product);
        applicationRepository.save(application);
        log.info("Application created: {}", application);
        return modelMapper.map(application, ApplicationResponse.class);
    }

    @Transactional
    public void accept(Long applicationId) {
        Application application = applicationRepository.findById(applicationId).orElseThrow();
        Product product = application.getProduct();
        application.setAccepted(true);
        application.setDecisionStatus(DecisionStatus.ACCEPT);
        productService.save(product);
        applicationRepository.save(application);
        log.info("Application accepted: {}", application);
    }

    @Transactional
    public void reject(Long applicationId, String rejectionReason) {
        Application application = applicationRepository.findById(applicationId).orElseThrow();
        Product product = application.getProduct();
        if (product != null) {
            application.setProduct(null);
            product.setApplication(null);
            productService.deleteById(product.getId());
        }
        application.setDecisionStatus(DecisionStatus.REJECT);
        application.setAccepted(false);
        application.setMessage(rejectionReason);
        applicationRepository.save(application);
        log.info("Application rejected: {}", application);
    }

    public ApplicationResponse getApplicationById(Long applicationId) {
        Application application = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new NoSuchElementException("Application not found"));
        log.info("Application retrieved: {}", application);
        return modelMapper.map(application, ApplicationResponse.class);
    }
}