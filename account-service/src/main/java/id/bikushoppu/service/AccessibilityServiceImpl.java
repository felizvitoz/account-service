package id.bikushoppu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.bikushoppu.entity.Accessibility;
import id.bikushoppu.repository.AccessibilityRepository;

@Service
public class AccessibilityServiceImpl implements AccessibilityService {

    @Autowired
    private AccessibilityRepository accessibilityRepository;

    @Override
    public Accessibility create(final Accessibility accessibility) throws Exception {
        return this.accessibilityRepository.save(accessibility);
    }
}
