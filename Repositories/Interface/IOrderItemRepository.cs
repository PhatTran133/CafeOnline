﻿using BussinessObjects.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repositories.Interface
{
    public interface IOrderItemRepository
    {
        Task AddOrderItemAsync(OrderItem orderItem);
    }
}