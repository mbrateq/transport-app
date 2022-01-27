package pl.sggw.transportapp.web.controller;

import org.springframework.data.domain.PageRequest;

public abstract class ControllerAbstract {
  protected PageRequest preparePageRequest(int page, int pageSize) {
    return PageRequest.of(page - 1, pageSize);
  }
}
