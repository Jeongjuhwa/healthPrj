package healthApp.healthPrj.repository.custom;

import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
public class GymRepositoryImpl implements GymRepositoryCustom{

    private final EntityManager em;
}
