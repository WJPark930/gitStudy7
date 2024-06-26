package movie.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import movie.model.MovieBean;
import movie.model.MovieDao;
import utility.Paging;

@Controller
public class MovieListController {
	private final String command = "list.mv";
	private final String getPage = "movieList";
	
	@Autowired
	MovieDao movieDao; 
	
	@RequestMapping(value = command)
	private ModelAndView list(
			@RequestParam(value = "whatColumn", required = false) String whatColumn, 
			@RequestParam(value = "keyword", required = false) String keyword,
			 @RequestParam(value = "pageNumber", required = false) String pageNumber,
			 HttpServletRequest request
			) {
		ModelAndView mav = new ModelAndView();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%" + keyword + "%");
		
		int totalCount = movieDao.getTotalCount(map); //Å°¿öµå °¹¼ö
		String url = request.getContextPath() + "/" +  this.command;
		 
		Paging pageInfo = new Paging(pageNumber,null,totalCount,url,whatColumn,keyword);
		
		List<MovieBean> movieList = movieDao.getMovieList(map,pageInfo);
		mav.addObject("movieList",movieList);
		mav.addObject("pageInfo",pageInfo);
		mav.setViewName(getPage); // movieList
		
		return mav;
	}
}