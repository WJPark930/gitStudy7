package movie.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utility.Paging;

@Service("myMovieDao")
public class MovieDao {

	private String namespace = "movie.MovieBean";

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public MovieDao() {
		System.out.println("MovieDao »ý¼ºÀÚ");
	}


	public List<MovieBean> getMovieList(Map<String, String> map,Paging pageInfo) {

		List<MovieBean> lists = new ArrayList<MovieBean>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList(namespace + ".getMovieList",map,rowBounds);
		System.out.println("lists.size():" + lists.size());

		return lists;
	}//getMovieList


	public int getTotalCount(Map<String, String> map) {
		int count = -1;
		count = sqlSessionTemplate.selectOne(namespace + ".getTotalCount", map);
		return count;
	}// getTotalCount


	public int insertMovie(MovieBean movie) {
		int cnt = -1;

		cnt = sqlSessionTemplate.insert(namespace + ".insertMovie", movie);
		System.out.println("insertMovie cnt:" + cnt);
		return cnt;
	}//insertMovie

	public int searchTitle(String inputtitle) {
		int count=-1;
		count = sqlSessionTemplate.selectOne(namespace + ".searchTitle",inputtitle); 
		return count;
	}//searchTitle


	public MovieBean getMovieByNum(int num) {
		MovieBean movie = null;
		movie = sqlSessionTemplate.selectOne(namespace+ ".getMovieByNum",num);
		return movie;
	}


	public int deleteMovie(int num) {
		int cnt = -1;
		cnt = sqlSessionTemplate.delete(namespace + ".deleteMovie",num);
		return cnt;		
	}

	public int updateMovie(MovieBean movie) {
		int cnt = -1;
		cnt = sqlSessionTemplate.update(namespace + ".updateMovie",movie);
		return cnt;
	}
}