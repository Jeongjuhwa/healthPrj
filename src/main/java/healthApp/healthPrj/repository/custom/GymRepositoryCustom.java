package healthApp.healthPrj.repository.custom;

import healthApp.healthPrj.entity.Gym;

import java.util.List;

public interface GymRepositoryCustom {


    List<Gym> findAcceptGymById(Long id);


}
