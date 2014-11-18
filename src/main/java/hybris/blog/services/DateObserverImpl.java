package hybris.blog.services;

import hybris.blog.cms.controllers.DashboardController;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static java.util.logging.Level.OFF;

@Component
@Transactional
public class DateObserverImpl implements DateObserver {
	
	private static final Logger LOG = Logger.getLogger(DashboardController.class.getName());
	
	@PersistenceContext
	EntityManager entityManager;
	
	/*
	 * Seach for date with specyfic year.month (day is irrelevant)
	 * if not, add it
	 */
	public void findOrCreateMonthUnit(Date date) {
		
		Date startDay = setDayToFirstOf(date);
		Date endDay = setDayToLastOf(date);
		
		Query query = entityManager
				.createQuery ("SELECT e FROM date_observer e WHERE e.date BETWEEN :startDate AND :endDate")
				.setParameter("startDate",startDay)  
				.setParameter("endDate", endDay); 
	
	}

	public List<Date> getFilledMonths() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * Helper methods that provide possibility to set day of Date object
	 * to first or last, for example, 2014.05.12 => 2014.05.30
	 */
	private Date setDayToFirstOf(Date date){
		return resetMonth(date, 0);
	}
	private Date setDayToLastOf(Date date){
		return resetMonth(date, -1);
	}
	private Date resetMonth(Date date, int flag){
        
		/*
		 * set 0 for first day
		 * set -1 for last day
		 */
			
		Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date);  

        calendar.add(Calendar.MONTH, 1);  
        calendar.set(Calendar.DAY_OF_MONTH, 1);  
        calendar.add(Calendar.DATE, flag);  

        Date processedDate = calendar.getTime();
        
        return processedDate;
        
	}
}
