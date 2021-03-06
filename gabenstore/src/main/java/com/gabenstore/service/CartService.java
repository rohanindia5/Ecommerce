package com.gabenstore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabenstore.dao.CartDAOImp;
import com.gabenstore.modal.CartItems;

@Transactional
@Service
public class CartService 
{
	@Autowired
	CartDAOImp cartDAOImp;
	public void addCart(CartItems cartItems)
	{
		cartDAOImp.addCart(cartItems);
	}
	
	public String displayCart(int userID)
	{
		return cartDAOImp.displayCart(userID);
	}
	
	public void deletecart(int cartItemsID) 
	{
		 cartDAOImp.deletecart(cartItemsID);
	}	
	
	public CartItems displayCartProduct(int productID)
	{
		return cartDAOImp.displayCartProduct(productID);
	}
	
	public List<CartItems> displayAddedCart(int userID)
	{
		return cartDAOImp.displayAddedCart(userID);
	}
	
	public List<CartItems> displayCart1(int userID)
	{
		return cartDAOImp.displayCart1(userID);
	}
	
	public void updateCart(int cartItemsID, int cartTotalAmount, int cartQuantity)
	{
		cartDAOImp.updateCart(cartItemsID, cartTotalAmount, cartQuantity);
	}
	
	public void updateCartOrders(int userID)
	{
		cartDAOImp.updateCartOrders(userID);
	}
}

