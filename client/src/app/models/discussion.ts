import { Message } from './message';

export class Discussion {
    id: string;
    timestamp: number;
    user1: string;
    user2: string;

    constructor(id: string, timestamp: number, user1: string, user2: string) {
        this.id = id;
        this.timestamp = timestamp;
        this.user1 = user1;
        this.user2 = user2;
      }
  }