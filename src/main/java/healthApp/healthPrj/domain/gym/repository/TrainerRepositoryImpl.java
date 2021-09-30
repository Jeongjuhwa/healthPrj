package healthApp.healthPrj.domain.gym.repository;

import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
public class TrainerRepositoryImpl implements TrainerRepositoryCustom{

    private final EntityManager em;
}
