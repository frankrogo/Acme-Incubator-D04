
package acme.features.administrator.toolRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.configurations.Configuration;
import acme.entities.toolRecords.ToolRecord;
import acme.features.administrator.configuration.AdministratorConfigurationRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorToolRecordUpdateService implements AbstractUpdateService<Administrator, ToolRecord> {

	@Autowired
	AdministratorToolRecordRepository				repository;

	@Autowired
	private AdministratorConfigurationRepository	configurationRepository;


	@Override
	public boolean authorise(final Request<ToolRecord> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<ToolRecord> request, final ToolRecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<ToolRecord> request, final ToolRecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "title", "sector", "inventorName", "description", "website", "email", "stars", "isOpenSource");
		Configuration config = this.configurationRepository.findOneConfiguration();
		String paramConfig = config.getActivitySectors();
		String[] params = paramConfig.split(",");
		model.setAttribute("params", params);
	}

	@Override
	public ToolRecord findOne(final Request<ToolRecord> request) {
		assert request != null;
		ToolRecord res = this.repository.findOneById(request.getModel().getInteger("id"));
		return res;
	}

	@Override
	public void validate(final Request<ToolRecord> request, final ToolRecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		Configuration config = this.configurationRepository.findOneConfiguration();
		String paramConfig = config.getActivitySectors();
		String[] params = paramConfig.split(",");
		request.getModel().setAttribute("params", params);
	}

	@Override
	public void update(final Request<ToolRecord> request, final ToolRecord entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}
}
