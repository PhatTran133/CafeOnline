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
    public class DrinkToppingRepository : IDrinkToppingRepository
    {
        private readonly CoffeeShopContext _context;
        public DrinkToppingRepository()
        {
            _context = new CoffeeShopContext();
        }

        public async Task<DrinkTopping?> FindByIdAsync(int id)
        {
            return await _context.DrinkToppings
                .Include(d => d.Drink)
                .Include(t => t.Topping)
                .FirstOrDefaultAsync(x => x.Id == id);
        }

        public async Task AddDrinkTopping(DrinkTopping drinkTopping)
        {
            await _context.DrinkToppings.AddAsync(drinkTopping);
            await _context.SaveChangesAsync();
        }

        public async Task<DrinkTopping?> FindByDrinkIdAndToppingId(int drinkId, int toppingId)
        {
            return await _context.DrinkToppings
                .FirstOrDefaultAsync(x => x.DrinkId == drinkId &&  x.ToppingId == toppingId);
        }
    }
}
