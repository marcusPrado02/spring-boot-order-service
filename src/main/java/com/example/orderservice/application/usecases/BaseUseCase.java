package orderservice.core.domain.entity;

public abstract BaseUseCase {
    private IService service;

    private static execute() {
        return this.service.execute();
    }
}