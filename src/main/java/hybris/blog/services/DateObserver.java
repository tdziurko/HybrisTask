package hybris.blog.services;

import java.util.Date;
import java.util.List;

public interface DateObserver {
	public void findOrCreateMonthUnit(Date date);
	public List<Date> getFilledMonths();
}
