package com.dmitrenko.repository;

import com.dmitrenko.domain.GameChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameChatRepository extends JpaRepository<GameChat, Integer> {
}
