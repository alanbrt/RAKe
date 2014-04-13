package com.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;

import com.modelo.Participante;

@ManagedBean
public class GerenciadorBean {

	public void geraCertificado()
	{
		
	}
	
	public void geraCracha()
	{
		
	}
	
	public void enviaArtigo()
	{
		
	}
	
	public List<Integer> randomRevisores()
	{
		ParticipanteBean bean = new ParticipanteBean();
		List<Participante> revisores =  new ArrayList<Participante>();
		int count = 0;
		List<Integer> r =  new ArrayList<Integer>(5);
		
		boolean randomOK = false;
		
		for(Participante p : bean.getParticipantes())
			if(p.isRevisor()) revisores.add(p);
		
		while(!randomOK)
		{
			for(int i=0;i<5;i++)
				r.add(1+(int)(revisores.size()*Math.random()));
			
		    for(int i=0;i<5;i++)
			for(int j=0;j<5;j++)
				if(r.get(i).equals(r.get(j))) count++;
		    
		    if(count == 5) randomOK = true;
		}
	    
		return r;
		
	}
	
	public List getListaArtigos()
	{
		return null;
		
	}
	
	public void enviaLista()
	{
		
	}
	
	public String getMenu()
	{
		return "menu.xhtml";
	}
}
