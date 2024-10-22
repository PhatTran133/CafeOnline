﻿using BussinessObjects.Models;
using Microsoft.EntityFrameworkCore;
using Repositories.Interface;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repositories
{
    public class CartItemRepository : ICartItemRepository
    {
        private readonly CoffeeShopContext _context;
        public CartItemRepository()
        {
            _context = new CoffeeShopContext();
        }
        public async Task AddCartItemAsync(CartItem cartItem)
        {
            _context.CartItems.Add(cartItem);
            await _context.SaveChangesAsync();
        }

        public async Task DeleteCartItemAsync(CartItem cartItem)
        {
            _context.CartItems.Remove(cartItem);
            await _context.SaveChangesAsync();
        }

        public async Task<CartItem?> GetCartItemAsync(int id)
        {
            return await _context.CartItems
                .Include(t => t.CartItemToppings)
                .ThenInclude(d => d.Topping)
                .FirstOrDefaultAsync(x => x.Id == id);
        }

        public async Task UpdateCartItemAsync(CartItem cartItem)
        {
            _context.CartItems.Update(cartItem);
            await _context.SaveChangesAsync();
        }
    }
}
