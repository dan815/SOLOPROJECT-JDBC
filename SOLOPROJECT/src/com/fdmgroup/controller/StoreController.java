package com.fdmgroup.controller;

import com.fdmgroup.dao.*;
import com.fdmgroup.view.*;

public class StoreController {
	private DashboardView dashboardView;
	private StoreView storeView;
	private IUserDao userDao;
	private ICardDao cardDao;
	
	public StoreController() {
		super();
	}
	public StoreController(DashboardView dashboardView, IUserDao userDao, ICardDao cardDao) {
		super();
		this.dashboardView = dashboardView;
		this.userDao = userDao;
		this.cardDao = cardDao;
		
	}
	@Override
	public String toString() {
		return "StoreController [cardDao=" + cardDao + ", dashboardView=" + dashboardView + ", userDao=" + userDao
				+ "]";
	}
	public DashboardView getDashboardView() {
		return dashboardView;
	}
	public void setDashboardView(DashboardView dashboardView) {
		this.dashboardView = dashboardView;
	}
	public IUserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	public ICardDao getCardDao() {
		return cardDao;
	}
	public StoreView getStoreView() {
		return storeView;
	}
	public void setStoreView(StoreView storeView) {
		this.storeView = storeView;
	}
	public void setCardDao(ICardDao cardDao) {
		this.cardDao = cardDao;
	}
	public void enterStore() {
		storeView.enterStore();
	}
	public void exitStore() {
		dashboardView.showDashboard();
		
	}

	
	
	
}
