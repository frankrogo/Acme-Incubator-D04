
package acme.features.investor.message;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.forums.Forum;
import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.messages.Message;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InvestorMessageRepository extends AbstractRepository {

	@Query("select m from Message m where m.forum.id = ?1")
	Collection<Message> findManyByForumId(int id);

	@Query("select m from Message m where m.id = ?1")
	Message findOneById(int id);

	@Query("select f from Forum f where f.id=?1")
	Forum findOneForumById(int id);

	@Query("select i from InvestmentRound i where exists(select a from Application a where a.investor.id = ?1 and a.investmentRound.id = i.id and a.status = 'accepted') and i.id = ?2")
	Collection<InvestmentRound> findInvestmentRound(int id, int iid);

	@Query("select ua.username from UserAccount ua where ua.id in (select au.userAccount.id from Authenticated au where au.id in (select ms.authenticated.id from Message ms where ms.id = ?1))")
	String findUser(int messageId);

	@Query("select f from Forum f where f.id=?1")
	Forum findForumById(int id);

}
