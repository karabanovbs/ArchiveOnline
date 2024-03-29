﻿using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Web;

namespace ArchiveOnlineDispatcherServices.Models
{
    public class Server
    {
        private static string archiveStatusResourceUrl = "/archiver/getStatus";

        public enum ServerType { COMPRESSOR, DEPRESSOR };

        //Класс статус сервера
        public class ServerStatus
        {
            public ServerStatus(long filesInProgress, int filesInQueueNow, int filesInProgressNow)
            {
                this.filesSizeAtAll = filesInProgress;
                this.filesInQueueNow = filesInQueueNow;
                this.filesInProgressNow = filesInProgressNow;
            }
            public long filesSizeAtAll;
            public int filesInQueueNow;
            public int filesInProgressNow;
        }

        //Id сервера
        private uint id;
        public uint Id
        {
            get
            {
                return id;
            }

            set
            {
                id = value;
            }
        }

        //Порт сервера
        private uint port;
        public uint Port
        {
            get
            {
                return port;
            }

            set
            {
                port = value;
            }
        }

        //Тип сервера, 0 - сжатие, 1 - расжатие
        private uint type;
        public uint Type
        {
            get
            {
                return type;
            }

            set
            {
                type = value;
            }
        }

        //Адрес сервера
        private string address;
        public string Address
        {
            get
            {
                return address;
            }

            set
            {
                address = value;
            }
        }

        //Формат с которым работает сервер
        private string format;
        public string Format
        {
            get
            {
                return format;
            }

            set
            {
                format = value;
            }
        }

        // Количество одноверменно запускаемых потоков
        private uint threadCount;
        public uint ThreadCount
        {
            get
            {
                return threadCount;
            }

            set
            {
                threadCount = value;
            }
        }

        //Размер очереди
        private uint queueSize;
        public uint QueueSize
        {
            get
            {
                return queueSize;
            }

            set
            {
                queueSize = value;
            }
        }

        //Последний полученный статус сервера
        private ServerStatus status;
        public ServerStatus Status
        {
            get
            {
                return status;
            }

            set
            {
                status = value;
            }
        }


        public Server(uint id, uint port, ServerType type, string address, string format, uint threadCount, uint queueSize)
        {
            this.id = id;
            this.port = port;
            this.type = (uint) type;
            this.address = address;
            this.format = format;
            this.threadCount = threadCount;
            this.queueSize = queueSize;
        }

        public Server(uint port, ServerType type, string address, string format, uint threadCount, uint queueSize)
        {
            this.port = port;
            this.type = (uint)type;
            this.address = address;
            this.format = format;
            this.threadCount = threadCount;
            this.queueSize = queueSize;
        }

        //Возвращает статус сервера
        public ServerStatus getServerStatus()
        {
            try
            {
                //Создаем запрос к веб ресурсу для проверки состояния сервера
                Uri uri = new Uri("http://" + this.Address + ":" + this.Port + archiveStatusResourceUrl);
                HttpWebRequest request = WebRequest.Create(uri) as HttpWebRequest;

                //Получаем ответ
                using (HttpWebResponse response = request.GetResponse() as HttpWebResponse)
                {
                    // Извлекаем содержимое запроса
                    StreamReader reader = new StreamReader(response.GetResponseStream());

                    //Конвертируем полученный JSON в объект
                    status = JsonConvert.DeserializeObject<Server.ServerStatus>(reader.ReadToEnd());

                }

            }
            catch (Exception ex)
            {
                Console.WriteLine("Server " + Address + ":" + Port + " is not available");
                status = null;
            }

            //Возвращаем статус сервера
            return status;
        }

        //Проверяет есть ли свободные места на сервере
        public bool hasFreePlaces()
        {
            return queueSize + threadCount > status.filesInProgressNow + status.filesInQueueNow;
        }

        //Проверяет доступен ли сервер
        public bool isAvailable()
        {
            try
            {
                HttpClient client = new HttpClient();
                client.BaseAddress = new Uri("http://" + this.Address + ":" + this.Port + archiveStatusResourceUrl);
                client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
                HttpResponseMessage response = client.GetAsync("").Result;
                return response.IsSuccessStatusCode;
            }
            catch (Exception ex)
            {
                Console.WriteLine("Server " + Address + ":" + Port + " is not available");
                return false;
            }

        }

    }
}