package com.qa.coolstore.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.coolstore.persistence.dao.OrderDAO;
import com.qa.coolstore.persistence.domain.Order;
import com.qa.coolstore.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}

	@Override
	public Order create() {
		LOGGER.info("Please the ID of the customer who placed the order");
		Long customerID = utils.getLong();
		LOGGER.info("Please enter the ID for the first product");
		Long itemID = utils.getLong();
		LOGGER.info("Please enter the quantity purchased");
		Long itemAmount = utils.getLong();
		LOGGER.info("Please enter the reference for the transaction this purchase relates to");
		Long ref = utils.getLong();
		Order order = orderDAO.create(new Order(customerID, itemID, itemAmount, ref));
		LOGGER.info("Order created");
		return order;
	}

	@Override
	public Order update() {
		LOGGER.info("Please the ID of the customer who placed the order");
		Long customerID = utils.getLong();
		LOGGER.info("Please enter the ID for the first product");
		Long itemID = utils.getLong();
		LOGGER.info("Please enter the quantity purchased");
		Long itemAmount = utils.getLong();
		LOGGER.info("Please enter the reference for the transaction this purchase relates to");
		Long ref = utils.getLong();
		Order order = orderDAO.create(new Order(customerID, itemID, itemAmount, ref));
		LOGGER.info("Order updated");
		return order;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = utils.getLong();
		return orderDAO.delete(id);
	}

}