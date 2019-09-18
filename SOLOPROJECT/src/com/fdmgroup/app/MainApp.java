package com.fdmgroup.app;

import java.util.Scanner;

import com.fdmgroup.controller.AuthenticationController;
import com.fdmgroup.controller.HomeController;
import com.fdmgroup.controller.StoreController;
<<<<<<< HEAD
import com.fdmgroup.dao.CardCollectionDao;
import com.fdmgroup.dao.ICardDao;
=======
>>>>>>> 47f17ff4d9fc89897d2fb70a03f77dd9acf1a184
import com.fdmgroup.dao.IUserDao;
import com.fdmgroup.dao.UserCollectionDao;
import com.fdmgroup.view.DashboardView;
import com.fdmgroup.view.HomeView;
import com.fdmgroup.view.StoreView;

public class MainApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		IUserDao userDao = new UserCollectionDao();
		ICardDao cardDao = new CardCollectionDao();
		
		//Views
		HomeView hv = new HomeView(scanner);
		DashboardView dv = new DashboardView(scanner);
		StoreView sv = new StoreView(scanner);
		
		//Controllers
		HomeController hc = new HomeController();
		AuthenticationController ac = new AuthenticationController();
		StoreController sc = new StoreController();
		
		//connecting view to controllers
		hc.setHomeView(hv);
		ac.setHomeView(hv);
		ac.setDashboardView(dv);
		sc.setDashboardView(dv);
		sc.setStoreView(sv);

		//connecting database to controllers
		ac.setUserDao(userDao);
<<<<<<< HEAD
		sc.setUserDao(userDao);
		sc.setCardDao(cardDao);
=======
		sc.setDashboardView(dv);
		sc.setStoreView(sv);
		sc.setUserDao(userDao);
>>>>>>> 47f17ff4d9fc89897d2fb70a03f77dd9acf1a184
		
		//connecting controllers to views
		hv.setHomeController(hc);
		hv.setAuthenticationController(ac);
		dv.setAuthenticationController(ac);
		dv.setStoreController(sc);
		sv.setStoreController(sc);
		
		hc.showHome();
		
		scanner.close();
	}
}









