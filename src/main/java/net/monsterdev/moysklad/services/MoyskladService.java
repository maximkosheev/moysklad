package net.monsterdev.moysklad.services;

import net.monsterdev.moysklad.model.Product;

import java.util.List;

public interface MoyskladService {
    /**
     * Устанавливает соединение с сервером Moysklad.ru
     * @param login - имя пользователя
     * @param password - пароль пользователя
     */
    void connect(String login, String password);

    /**
     * Возвращает список товаров
     * @return - список товаров
     */
    List<Product> getProducts();
}
