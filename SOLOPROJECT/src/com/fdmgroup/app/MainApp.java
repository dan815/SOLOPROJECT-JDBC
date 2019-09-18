package com.fdmgroup.app;

import java.util.Scanner;

import com.fdmgroup.controller.AuthenticationController;
import com.fdmgroup.controller.HomeController;
import com.fdmgroup.controller.StoreController;
import com.fdmgroup.dao.IUserDao;
import com.fdmgroup.dao.UserCollectionDao;
import com.fdmgroup.view.DashboardView;
import com.fdmgroup.view.HomeView;
import com.fdmgroup.view.StoreView;

public class MainApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		IUserDao userDao = new UserCollectionDao();
		
		//Views
		HomeView hv = new HomeView(scanner);
		DashboardView dv = new DashboardView(scanner);
		StoreView sv = new StoreView(scanner);
		
		//Controllers
		HomeController hc = new HomeController();
		AuthenticationController ac = new AuthenticationController();
		StoreController sc = new StoreController();
		
		hc.setHomeView(hv);
		ac.setDashboardView(dv);
		ac.setHomeView(hv);
		ac.setUserDao(userDao);
		sc.setDashboardView(dv);
		sc.setStoreView(sv);
		sc.setUserDao(userDao);
		
		hv.setAuthenticationController(ac);
		hv.setHomeController(hc);
		dv.setAuthenticationController(ac);
		dv.setStoreController(sc);
		sv.setStoreController(sc);
		
		hc.showHome();
		
		scanner.close();
	}
}









