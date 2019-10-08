package pl.coderslab.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.app.model.Advertisement;


public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
}
