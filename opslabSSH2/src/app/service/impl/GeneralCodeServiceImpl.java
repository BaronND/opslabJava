package app.service.impl;

import app.entries.GeneralCode;
import app.service.GeneralCodeService;
import app.service.RightsService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <h6>Description:<h6>
 * <p></p>
 *
 * @date 2015-06-15.
 */
@Service("generalCodeService")
public class GeneralCodeServiceImpl extends SupportServiceImpl<GeneralCode> implements GeneralCodeService {
    @Resource(name = "rightsService") @Getter @Setter private RightsService service;
}
