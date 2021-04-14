/**
 * 
 */
package cd.java.springfun.ninjagold;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

/**
 * @author ccomstock
 *
 */
@Controller
public class MainController {

	@GetMapping("/")
	public String index(Model model, HttpSession session) {
		if(model.getAttribute("title") == null)
			model.addAttribute("title", "Ninja Gold");
		ArrayList<Place> places = (ArrayList<Place>) session.getAttribute("places");
		if(places == null) {
			places = new ArrayList<Place>(4);
			places.add(new Place("Farm", 10, 20));
			places.add(new Place("Cave", 5, 10));
			places.add(new Place("House", 2, 5));
			places.add(new Place("Casino", -50, 50));
			places.add(new Place("Spa", -20, -5));
			session.setAttribute("places", places);
		}
		ArrayList<Activity> activities = (ArrayList<Activity>) session.getAttribute("activities");
		if(activities == null) {
			activities = new ArrayList<Activity>();
			session.setAttribute("activities", activities);
		}
		Integer ninjaGold = (Integer) session.getAttribute("ninjaGold");
		if(ninjaGold == null) {
			ninjaGold = 0;
			session.setAttribute("ninjaGold", ninjaGold);
		}
		return "index.jsp";
	}
	
	@PostMapping("/submit")
	public String submit(@RequestParam(value="place") String placeName, HttpSession session, Model model) {
//		System.out.println("MainController.submit(): ReqParam place = " + placeName);
		ArrayList<Activity> activities = (ArrayList<Activity>) session.getAttribute("activities");
		if(activities == null) activities = new ArrayList<Activity>();
		Integer ninjaGold = (Integer) session.getAttribute("ninjaGold");
		if(ninjaGold == null) ninjaGold = 0;
		ArrayList<Place> places = (ArrayList<Place>) session.getAttribute("places");
//		System.out.println("places = " + places);
		if(places == null) {
			System.out.println("MainController.submit(): tried to get places[] but session returned null");
			return "redirect:/";
		}
		Place place = null;
		for(int i = 0; i < places.size(); i++) {
			if(places.get(i).getName().equalsIgnoreCase(placeName)) {
				place = places.get(i);
				break;
			}
		}
		if(place != null) {
			int gold = place.getGold();
			String color = "";
			String message = "";
			if(place.getName().equalsIgnoreCase("Casino") || place.getName().equalsIgnoreCase("Spa")) {
				if(gold > 0) {
					color = "success";
					message = String.format("Won %d gold at the %s! - ",  gold, place.getName());
				}
				else if (gold < 0) {
					color = "danger";
					message = String.format("Lost %d gold at the %s... Ouch... - ", Math.abs(gold), place.getName());
				}
				else {
					color = "Dark";
					message = String.format("Broke even at the %s", place.getName());
				}
			}
			else {
				color = "success";
				message = String.format("Found %d gold at the %s! - ", gold, place.getName());
			}
			message += ZonedDateTime.now().format(DateTimeFormatter.ofPattern("uuuu/MM/dd  h:mm a"));
			activities.add(0, new Activity(color, message));
			ninjaGold += gold;
		}
		session.setAttribute("activities", activities);
		session.setAttribute("ninjaGold", ninjaGold);
		return "redirect:/";
	}
	
	@GetMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
