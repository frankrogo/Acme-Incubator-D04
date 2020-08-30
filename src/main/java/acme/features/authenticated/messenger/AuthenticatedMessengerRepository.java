
package acme.features.authenticated.messenger;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.messengers.Messenger;
import acme.framework.entities.Authenticated;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedMessengerRepository extends AbstractRepository {

	@Query("select m from Messenger m where m.ownsTheForum=true and m.forum.id = ?1")
	Messenger findTheOwner(int id);

	@Query("select m from Messenger m where m.id = ?1")
	Messenger findOneById(int id);

	@Query("select m from Messenger m where m.forum.id = ?1")
	Collection<Messenger> findMessengersByForumId(int id);

	@Query("select au from Authenticated au where au.userAccount.id = ?1")
	Authenticated findAuthByAccountId(int id);
}
