﻿using BussinessObjects.Models;
using DataAccess;
using Repositories.Interface;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repositories
{
    public class DrinkRepository : IDrinkRepository
    {
        public Task<List<Drink>> SearchDrinksByNameAsync(string name) => DrinkDAO.Instance.SearchDrinksByNameAsync(name);
        public Task<List<Drink>> FilterDrinksAsync(string? categoryName, decimal? minPrice, decimal? maxPrice, DateTime? startDate, DateTime? endDate, string? size) => DrinkDAO.Instance.FilterDrinksAsync(categoryName, minPrice, maxPrice, startDate, endDate, size);
    }
}
