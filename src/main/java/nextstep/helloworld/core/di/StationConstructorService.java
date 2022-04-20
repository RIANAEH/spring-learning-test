package nextstep.helloworld.core.di;

import java.beans.ConstructorProperties;
import org.springframework.stereotype.Service;

@Service
public class StationConstructorService {
    private StationRepository stationRepository;

    @ConstructorProperties({"stationRepository"})
    public StationConstructorService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public String sayHi() {
        return stationRepository.sayHi();
    }
}
