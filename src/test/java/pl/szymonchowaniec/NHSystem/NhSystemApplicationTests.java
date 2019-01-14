package pl.szymonchowaniec.NHSystem;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.szymonchowaniec.NHSystem.Model.Member;
import pl.szymonchowaniec.NHSystem.Model.Task;
import pl.szymonchowaniec.NHSystem.Service.MemberService;
import pl.szymonchowaniec.NHSystem.Service.TaskService;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NhSystemApplicationTests {

	@Autowired
	private MemberService memberService;

	@Autowired
	private TaskService taskService;

	@Before
	public void initDB(){
		{
			Member member = new Member("testMember@mail.com","test","member");
			memberService.createMember(member);
		}
		{
			Member member = new Member("testAdmin@mail.com","testAdmin","admin");
			memberService.createMember(member);
		}

		Task memberTask = new Task("12-12-2012","00:00","00:01","Do anything");
		taskService.addTask(memberTask,memberService.findOne("testMember@mail.com"));
	}
	@Test
	public void testMember(){

		Member member = memberService.findOne("testMember@mail.com");
		assertNotNull(member);

		Member admin = memberService.findOne("testAdmin@mail.com");
		assertEquals(admin.getEmail(),"testAdmin@mail.com");

	}

	@Test
	public void testTask(){
		Member member = memberService.findOne("testMember@mail.com");
		List<Task> tasks = taskService.findMemberTasks(member);

		assertNotNull(tasks);
	}


}

