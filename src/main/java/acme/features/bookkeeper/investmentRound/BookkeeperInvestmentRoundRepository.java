
package acme.features.bookkeeper.investmentRound;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.investmentRounds.InvestmentRound;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface BookkeeperInvestmentRoundRepository extends AbstractRepository {

	@Query("select distinct j from Bookkeeper a join a.accountingRecords ar join ar.investmentRound j on a.id=?1")
	Collection<InvestmentRound> findManyByBookkeeperId(int id);

	@Query("select j from InvestmentRound j where j not in (select distinct j1 from Bookkeeper a join a.accountingRecords ar join ar.investmentRound j1 where a.id=?1)")
	Collection<InvestmentRound> findManyByNotMyBookkeeperId(int id);

	@Query("select j from InvestmentRound j where j.id=?1")
	InvestmentRound findOneById(int id);

}
