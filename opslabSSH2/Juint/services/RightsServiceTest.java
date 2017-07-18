package services;

import app.entries.EntryPage;
import app.entries.Rights;
import app.service.RightsService;
import evilp0s.RandomUtil;
import org.junit.Test;

import java.util.List;

public class RightsServiceTest extends TestUtil{

	@Test
	public void getMenuList(){
		RightsService service = (RightsService) Context.getBean("rightsService");
		
		List<?> list = service.getMenuList();
		
		System.out.println(list.size());
	}

	@Test
	public void getQuery(){
		RightsService service = (RightsService)Context.getBean("rightsService");
		long currentTimeMillis = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			EntryPage entryPage = service.getQuery(1, 30);
			System.out.println(entryPage.getList());
		}
		long currentTimeMillis1 = System.currentTimeMillis();
		System.out.println(currentTimeMillis1 - currentTimeMillis);
	}
	
	@Test
	public void save(){
		RightsService service = (RightsService) Context.getBean("rightsService");
		for(int i=0;i<10000;i++){
			Rights r = new Rights();
			r.setRightsName("11111");
			r.setIsBranch(false);
			r.setIsValid(true);
			switch (RandomUtil.integer(0, 10)) {
			case 1:
				r.setGroupId("837");
				break;
			case 2:
				r.setGroupId("839");
				break;
			case 3:
				r.setGroupId("844");
				break;
			case 4:
				r.setGroupId("846");
				break;
			case 5:
				r.setGroupId("848");
				break;
			case 6:
				r.setGroupId("863");
				break;
			case 7:
				r.setGroupId("865");
				break;
			case 8:
				r.setGroupId("861");
				break;
			default:
				r.setGroupId("837");
				break;
			}
			service.save(r);
		}
		
	}
}
