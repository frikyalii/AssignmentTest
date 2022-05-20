package com.capgemini.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.model.Branch;
import com.capgemini.repository.branchRepository;

@Service
public class branchServiceImplementaion implements branchService {

	@Autowired
	private branchRepository branchRepo;

	

	public branchServiceImplementaion(branchRepository branchRepo) {
		super();
		this.branchRepo = branchRepo;
	}

	@Override
	public Branch addBranch(Branch branch) {
		Branch branchSave=branchRepo.save(branch);
		return branchSave ;
	}

	@Override
	public List getAllBranch() {
		return branchRepo.findAll();
	}

	@Override
	public void deleteBranch(int bid) {
         branchRepo.deleteById(bid);		
	}
	

	@Override
	public Branch updateBranch(Branch branch) {
		Optional<Branch> branchDb=this.branchRepo.findById(branch.getBid());
		if(branchDb.isPresent())
		{
			Branch branchUpdate=branchDb.get();
			branchUpdate.setBid(branch.getBid());
			branchUpdate.setBcode(branch.getBcode());
			branchUpdate.setLocation(branch.getLocation());
			branchRepo.save(branchUpdate);
			return branchUpdate;
		}
		else
		{
			return branch;
		}
	}
	
	
	//@Override
//	public Population updatePopulationData(Population pop) throws PopulationIdNotFound  {
//		// TODO Auto-generated method stub
//		Optional<Population> popDb = this.popRepo.findById(pop.getId());
//
//        if (popDb.isPresent()) {
//        	Population popUpdate = popDb.get();
//            popUpdate.setId(pop.getId());
//            popUpdate.setCity(pop.getCity());
//            popUpdate.setPop(pop.getPop());
//            popUpdate.setState(pop.getState());
//            popRepo.save(popUpdate);
//            return popUpdate;
//        }
//        else
//        {
//        	throw new PopulationIdNotFound();
//        }
//    }


	

}
